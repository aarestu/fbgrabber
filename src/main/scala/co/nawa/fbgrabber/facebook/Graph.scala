package co.nawa.fbgrabber.facebook

import co.nawa.fbgrabber.model.{Message, PagePostRoot}

import scalaj.http._
import net.liftweb.json._

object Graph {

  implicit val formats = net.liftweb.json.DefaultFormats

  val accessTokenEnvName = "FACEBOOK_ACCESS_TOKEN"
  val url = "https://graph.facebook.com/"

  def accessToken =
    Option(System.getenv(accessTokenEnvName)).getOrElse(
      throw new Exception(
        "The " + accessTokenEnvName +" environment variable is not set. To get " +
          "your Facebook access token, go to " +
          "https://developers.facebook.com/tools/explorer?method=GET&path=me "
      ))


  def apiURL(id: String, path: String, limit: Int, fields: String) =
    Http(url + id + "/" + path).params(Map(
      "fields" -> fields,
      "access_token" -> accessToken,
      "limit" -> limit.toString
    ))

  def getMessagePost(id: String = "me", limit: Int = 20) :PagePostRoot = {

    val request = apiURL(id = id, "feed", fields = "id,message", limit = limit)

    val response = request.asString
    val json = parse(response.body)

    val pagePostRoot = json.extract[PagePostRoot]
    pagePostRoot
  }
}

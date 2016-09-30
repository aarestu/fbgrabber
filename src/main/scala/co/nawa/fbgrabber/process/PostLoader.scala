package co.nawa.fbgrabber.process

import co.nawa.fbgrabber.facebook.Graph
object PostLoader {

  def main(args: Array[String]) = {
    val pagePostRoot = Graph.getMessagePost("241806149201604")

    for (data <- pagePostRoot.data) {
      println (data.id + " + " + data.message)
    }
  }

}

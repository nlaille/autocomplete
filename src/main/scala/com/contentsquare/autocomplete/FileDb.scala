package com.contentsquare.autocomplete

import scala.io.Source

object FileDb {
  def get(path:String) : Seq[String] = {
    Source.fromFile(path).getLines().toSeq
  }
}

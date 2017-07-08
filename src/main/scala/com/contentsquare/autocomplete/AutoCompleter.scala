package com.contentsquare.autocomplete

trait AutoCompleter {
  def startWith(word:String, maxResult:Int = 4) : Seq[String]
}

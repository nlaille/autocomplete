package com.contentsquare.autocomplete

class SimpleAutoCompleter(words: Seq[String]) extends AutoCompleter {

  override def startWith(word: String, maxResult:Int = 4): Seq[String] = {
    words.filter(_.startsWith(word)).slice(0, maxResult)
  }
}

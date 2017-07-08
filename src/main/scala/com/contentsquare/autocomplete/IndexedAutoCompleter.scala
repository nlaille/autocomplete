package com.contentsquare.autocomplete

class IndexedAutoCompleter(words: Seq[String]) extends AutoCompleter {

  private val wordsIndexed:Map[String, Seq[String]] = groupPerPrefix(words.flatMap(procceedWord))

  override def startWith(word: String, maxResult:Int = 4): Seq[String] = {
    wordsIndexed.getOrElse(word.toLowerCase, Seq()).slice(0, maxResult)
  }

  private def procceedWord(word:String):Seq[(String, String)] = {
    sliceWord(word).map(x => (x.toLowerCase, word))
  }

  private def sliceWord(word:String): Seq[String] = {
    for( i <- 1 to word.length) yield word.substring(0, i)
  }

  private def groupPerPrefix(words:Seq[(String, String)]):Map[String, Seq[String]] = {
    val grouped = words.groupBy(_._1)
    grouped.mapValues(_.map(_._2))
  }
}

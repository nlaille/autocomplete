package com.contentsquare.autocomplete

import org.slf4j.LoggerFactory

object IndexedAutoCompleterFromFile {
  lazy val logger = LoggerFactory.getLogger(this.getClass)

  def main(args:Array[String]) = {
    if (args.length != 2) {
      println("Usage [file] [word]")
      System.exit(1)
    }
    val words = FileDb.get(args(0))
    val tsBeforeIndexed = System.currentTimeMillis()
    val autoCompleter = new IndexedAutoCompleter(words)
    val tsAfterIndexed = System.currentTimeMillis()
    logger.info("Index {} words in {}ms", words.size, tsAfterIndexed - tsBeforeIndexed)

    val tsBeforeSearch = System.currentTimeMillis()
    val found = autoCompleter.startWith(args(1))
    val tsAfterSearch = System.currentTimeMillis()
    found.foreach(println)
    logger.info("Found in {}ms", tsAfterSearch - tsBeforeSearch)
  }
}

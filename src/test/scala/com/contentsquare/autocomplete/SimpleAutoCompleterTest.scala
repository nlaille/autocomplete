package com.contentsquare.autocomplete

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SimpleAutoCompleterTest extends FunSuite {
  val ANY_WORD = "any_word"

  test("autocomplete on empty list return empty result") {
    val autocompleter = new SimpleAutoCompleter(Seq())

    assert(autocompleter.startWith(ANY_WORD).isEmpty)
  }

  test("autocomplete on list('word', 'wo', 'wor') for 'wo' should match list('word', 'wo', 'wor')") {
    val autocompleter = new SimpleAutoCompleter(Seq("word", "wo", "wor"))

    assert(autocompleter.startWith("wo").equals(Seq("word", "wo", "wor")))
  }
}

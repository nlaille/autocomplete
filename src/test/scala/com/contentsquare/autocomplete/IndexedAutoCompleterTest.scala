package com.contentsquare.autocomplete

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IndexedAutoCompleterTest extends FunSuite {
  val ANY_WORD = "any_word"

  test("autocomplete on empty list return empty result") {
    val autocompleter = new IndexedAutoCompleter(Seq())

    assert(autocompleter.startWith(ANY_WORD).isEmpty)
  }

  test("autocomplete on list('word', 'wo', 'wor') for 'wo' should match list('word', 'wo', 'wor')") {
    val autocompleter = new IndexedAutoCompleter(Seq("word", "wo", "wor"))

    assert(autocompleter.startWith("wo").equals(Seq("word", "wo", "wor")))
  }

  test("autocomplete from input/sample1 for 'p' should match list('pandora', 'pinterest', 'paypal', 'pg&e')") {
    val autocompleter = new IndexedAutoCompleter(FileDb.get("input/sample1.txt"))

    assert(autocompleter.startWith("p").equals(Seq("Pandora", "Pinterest", "Paypal", "Pg&e")))
  }

  test("autocomplete from input/sample1 for 'pro'") {
    val autocompleter = new IndexedAutoCompleter(FileDb.get("input/sample1.txt"))

    assert(autocompleter.startWith("prog").equals(Seq("Progressive", "Programming", "Progeria", "Progesterone")))
  }
}

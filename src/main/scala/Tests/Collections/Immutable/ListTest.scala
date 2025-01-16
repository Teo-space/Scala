package Tests.Collections.Immutable

object ListTest {
	def Run(): Unit = {
		println()
		println("ListTest")

		val names: List[String] = List("Joel", "Chris", "Ed")

		var ints: List[Int] = List(1, 2, 3)

		ints = 0 +: ints;
		ints = ints :+ 4;

		println(ints)

		println(f"Max: ${ints.max}")
		println(f"Length: ${ints.length}")
		println(f"filter: ${ints.filter(x => x > 2)}")

		println(ints.map(x => f"x: $x").toArray())
		println(ints.map(x => f"x: $x").toList)
		println(ints.map(x => f"x: $x").toSet)
		println(ints.map(x => f"x: $x").toVector)
		println(ints.map(x => f"x: $x").toSeq)

		println(f"ListBuffer testAppended")
		var testAppended: List[Int] = List()
		Globals.Time {
			for(i <- 1 to 10000){
				testAppended = testAppended.appended(i)
			}
		}

		println(f"ListBuffer testAppended take")
		Globals.Time {
			testAppended.take(100)
		}

		println(f"ListBuffer testPrepended")
		var testPrepended: List[Int] = List()
		Globals.Time {
			for (i <- 1 to 100_000) {
				testPrepended = testPrepended.prepended(i)
			}
		}




	}

}

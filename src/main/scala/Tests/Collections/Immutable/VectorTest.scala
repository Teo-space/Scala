package Tests.Collections.Immutable

object VectorTest {
	def Run(): Unit = {

		val names: Vector[String] = Vector("Joel", "Chris", "Ed")
		println(names)
		names foreach println
		names.foreach(x => println(x))

		var ints: Vector[Int] = Vector(1, 2, 3)

		ints = ints.prepended(0)
		ints = ints.appended(4)
		ints = ints.appended(4)

		println(ints)

		println(f"Max: ${ints.max}")
		println(f"Length: ${ints.length}")
		println(f"filter: ${ints.filter(x => x > 2)}")

		println(ints.view.map(x => f"x: $x").toList)
		println(ints.map(x => f"x: $x").toSet)

		{
			case class Person(name: String)
			val people = Vector(
				Person("Bert"),
				Person("Ernie"),
				Person("Grover")
			)

			people foreach println
		}

		println(f"Vector testAppended")
		var testAppended: Vector[Int] = Vector()
		Globals.Time {
			for (i <- 1 to 10000) {
				testAppended = testAppended.appended(i)
			}
		}

		println(f"Vector testPrepended")
		var testPrepended: Vector[Int] = Vector()
		Globals.Time {
			for (i <- 1 to 100_000) {
				testPrepended = testPrepended.prepended(i)
			}
		}
	}

}

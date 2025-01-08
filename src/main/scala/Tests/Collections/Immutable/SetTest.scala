package Tests.Collections.Immutable

object SetTest {
	def Run(): Unit = {

		val names: Set[String] = Set("Joel", "Chris", "Ed")
		println(names)
		names foreach println
		names.foreach(x => println(x))

		var ints: Set[Int] = Set(1, 2, 3)

		ints = ints + 0
		ints = ints + 4
		ints = ints + 4

		println(ints)

		println(f"Max: ${ints.max}")
		println(f"Length: ${ints.count(x => true)}")
		println(f"filter: ${ints.filter(x => x > 2)}")

		println(ints.view.map(x => f"x: $x").toVector)

		{
			case class Person(name: String)
			val people = Set(
				Person("Bert"),
				Person("Ernie"),
				Person("Grover")
			)

			people foreach println
		}
	}
}

package Tests.Collections.Immutable

import scala.collection.immutable.SortedSet

object SortedSetTest {
	def Run(): Unit = {

		val names: SortedSet[String] = SortedSet("Joel", "Chris", "Ed")
		println(names)
		names foreach println
		names.foreach(x => println(x))

		var ints: SortedSet[Int] = SortedSet(1, 2, 3)

		ints = ints + 0
		ints = ints + 4
		ints = ints + 4

		println(ints)

		println(f"Max: ${ints.max}")
		println(f"Length: ${ints.count(x => true)}")
		println(f"filter: ${ints.filter(x => x > 2)}")

		println(ints.view.map(x => f"x: $x").toVector)

	}
}

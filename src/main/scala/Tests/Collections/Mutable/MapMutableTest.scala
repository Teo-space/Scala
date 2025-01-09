package Tests.Collections.Mutable

import scala.collection.*

object MapMutableTest {
	def Run(): Unit = {
		println()
		println("MapMutableTest")

		val map: mutable.Map[Int, String] = mutable.Map(1 -> "One");

		map.addOne(5 -> "five");
		println(map)


		println(f"Map testAdd")
		var testAdd: mutable.Map[Int, String] = mutable.Map();
		Globals.Time {
			for (i <- 1 to 100_000) {
				testAdd.addOne(i -> i.toString);
			}
		}

		println(f"Map testGet")
		Globals.Time {
			for (i <- 1 to 100_000) {
				val value = testAdd(i);
			}
		}
	}
}

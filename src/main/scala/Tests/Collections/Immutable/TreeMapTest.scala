package Tests.Collections.Immutable

import scala.collection.immutable.*

object TreeMapTest {
	def Run(): Unit = {
		println()
		println("TreeMapTest")
		println(this.getClass.getTypeName)

		var map: TreeMap[Int, String] = TreeMap(1 -> "One");

		map = map ++ Map(4 -> "four");
		map = map + (5 -> "five");

		println(map)

		println(f"Map testMerge")
		var testMerge: TreeMap[Int, String] = TreeMap();
		Globals.Time {
			for (i <- 1 to 100_000) {
				testMerge = testMerge ++ Map(i -> i.toString);
			}
		}

		println(f"Map testAdd")
		var testAdd: TreeMap[Int, String] = TreeMap();
		Globals.Time {
			for (i <- 1 to 100_000) {
				testAdd = testAdd + (i -> i.toString);
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

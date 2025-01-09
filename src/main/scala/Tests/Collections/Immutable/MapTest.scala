package Tests.Collections.Immutable

object MapTest {
	def Run(): Unit = {
		println()
		println("MapTest")

		var map: Map[Int, String] = Map(1 -> "One");

		map = map ++ Map(4 -> "four");
		map = map + (5 -> "five");

		println(map)

		println(f"Map testMerge")
		var testMerge: Map[Int, String] = Map();
		Globals.Time {
			for (i <- 1 to 100_000) {
				testMerge = testMerge ++ Map(i -> i.toString);
			}
		}

		println(f"Map testAdd")
		var testAdd: Map[Int, String] = Map();
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

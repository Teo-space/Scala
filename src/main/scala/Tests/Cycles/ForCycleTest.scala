package Tests.Cycles

object ForCycleTest {
	def Run(): Unit = {
		for(i <- 0 to 10){
			println(i);
		}

		val people = List(
			"Bill",
			"Candy",
			"Karen",
			"Leo",
			"Regina"
		)

		for (p <- people) println(p)

		val ratings = Map(
			"Lady in the Water" -> 3.0,
			"Snakes on a Plane" -> 4.0,
			"You, Me and Dupree" -> 3.5
		)

		for ((name,rating) <- ratings) println(f"Movie: $name, Rating: $rating")

		ratings.foreach {
			case (movie, rating) => println(s"key: $movie, value: $rating")
		}

		println(for (v <- 1 until 10) yield v * v)

		println({
			for {
				v <- 1 until 10 if v%2 == 0
			} yield {
				v * v
			}
		})

		for {
			i <- 1 to 3
			j <- 1 to 3
		} {
			println(s"i: $i, j: $j")
		}

		val colorList = Seq("R", "G", "B")
		for (c1 <- colorList; c2 <- colorList; c3 <- colorList) {
			println(s"c1: $c1. c2: $c2. c3: $c3.")
		}

	}
}

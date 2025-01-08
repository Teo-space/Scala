package Tests.Strings

object StringInterpolation
{
	def Run(): Unit =
	{
		println(s"Start")
		println({
			val name = "James"
			val age = 30
			s"$name is $age years old"
		})

		//не нужно писать return
		println({
			def abs(n: Int) = {
				if(n >= 0) n
				else -n
			}
			abs(-100)
		})
	}
}
  
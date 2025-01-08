package Tests.Collections

object StringBuilderTest {
	def Run(): Unit = {
		val buf = new StringBuilder

		buf += 'a'
		buf ++= "bcdef"
		print(buf.toString)
		
	}
}

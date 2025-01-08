package object Globals
{
	def Time[R](block: => R): R = {
		val tSt = System.nanoTime()
		val result = block // call-by-name
		val tEnd = System.nanoTime()
		println(f"Elapsed time: ${(tEnd - tSt) / 1000_000_000} s, ${(tEnd - tSt) / 1000_000} ms, ${(tEnd - tSt)} ns")
		result
	}

}

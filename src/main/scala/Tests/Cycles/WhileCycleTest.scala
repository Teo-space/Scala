package Tests.Cycles

object WhileCycleTest {
	def Run(): Unit = {
		var i: Int = 0;

		while(i<10){
			i += 1;
			println(i);
		}
	}
}

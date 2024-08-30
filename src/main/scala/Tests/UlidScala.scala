package Tests

import io.github.mutsuhiro6.util.ULID;
import java.time.Instant;

object UlidScala {
	def Run(): Unit = {

		println(s"ULID.of ${ULID.of("01FV2JEZNHE2CF8A85MRBVQ2PN")}")
		println()
		{
			println(s"ULID() : ${ULID()}")
			println(s"mostSigBits : ${ULID().mostSigBits}")
			println(s"leastSigBits : ${ULID().leastSigBits}")

			Thread.sleep(1111);

			println(s"ULID() : ${ULID()}")
			println(s"mostSigBits : ${ULID().mostSigBits}")
			println(s"leastSigBits : ${ULID().leastSigBits}")

			println()
		}

		println(s"ULID().timestamp : ${ULID().timestamp}")
		println(s"Instant.now.toEpochMilli : ${Instant.now.toEpochMilli}")
		println()

		println(ULID(0L))
		println(ULID(Instant.now.getEpochSecond, 0L))
		println(ULID(Instant.now.toEpochMilli, 0L))

		println(ULID(Instant.now.getEpochSecond))
		println(ULID(Instant.now.toEpochMilli))

	}
}

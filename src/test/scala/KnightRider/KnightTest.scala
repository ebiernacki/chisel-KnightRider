package KnightRider

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class KnightTest extends AnyFlatSpec with ChiselScalatestTester {
  "KnightTest test" should "pass" in {
    test(new KnightRider(4)).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
      for (i <- 0 until 500) {
        println(dut.io.led.peek().toString())
        dut.clock.step(1)

        // example code simulate a switch on at 150 clock ticks
        // if(i === 150){
        //   dut.io.sw.poke(1.U)
        // }
      }
      
    }
  }
}
/*
 * Code adapted from: https://github.com/schoeberl/chisel-examples
 * for differnt FPGA development board(Basys3)
 * 
 * A simple finite state machine (FSM) that drives LEDs like
 * on the lights on the Knight Rider car.
 */

package KnightRider

import chisel3._
import chisel3.stage._

/**
* Control blinking with FSM and AnyCounter clocking  
*/
class KnightRider(period: Int) extends Module {
	val io = IO(new Bundle {
		val led = Output(UInt(16.W))
	})
	/*
	* ATTENTION: THE FOLLOWING CODE IS BROKEN! 
	* See assignment for details
	*/
	val ledReg = RegInit(1.U(16.W))

	val goLeft :: goRight :: Nil = util.Enum(2)
	val stateReg = RegInit(goLeft)

	val counter = Module(new AnyCounter(period, 32))

	when(counter.io.flag){
		when(stateReg === goLeft){
			ledReg := ledReg << 1
		}.otherwise{
			ledReg := ledReg >> 1
		}

		when(ledReg(15) === 1.U){
			stateReg := goRight
		}
		when(ledReg(0) === 1.U){
			stateReg := goLeft
		}
	}

	io.led := ledReg
	
}


/**
 * Top level to connect leds and create sv file
 */
object KnightTopMain extends App{
	class KnightTop extends Module {
		val io = IO(new Bundle {
			val board_led = Output(UInt(16.W))
		})

		// Basys3 has a 100 MHz clock: 100000000 ticks
		val knight = Module(new KnightRider(100000000/6))

	}
    
	new circt.stage.ChiselStage().execute(args,Seq(circt.stage.CIRCTTargetAnnotation(circt.stage.CIRCTTarget.SystemVerilog), ChiselGeneratorAnnotation(() => new KnightTop)))
}


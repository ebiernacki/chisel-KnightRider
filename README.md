# Chisel Knight Rider 
The code provided in ```KnightRider.scala``` is broken. As discussed in class, the current code shifts the LED register until it is all the way to the right, but performs another shift that shifts the 1 off the 16 bit value. Below is the waveform at the time this happens. 

  <img src=".\waveform.png" alt="Alt text" style="width: 100%; height: 100%;">

Looking at the code, you can see how the value in the LED register updates(is shifted) on the rising clock edge(where the red cursor line is) as the flag goes up, causing it to be shifted off even though the state changes.

**Assignment Tasks:**
- First fix the problem described above so that the generated hardware correctly shifts the LED on the board back and forth forever
- Next, add a unique feature to the design. Such as a switch or button that:
    - stops the LED until its pressed again
    - reversed the direction of the LED
    - changes the speed of the LED
    - feel free to get creative

If possible bring your board and design to class to show it off.

Remember to add the IO for any switches or buttons to both the Chisel code and vivado .xdc constraints file!

**Getting the Repo:**
```bash
$ git clone https://github.com/ebiernacki/chisel-KnightRider.git 
```


## External Setup Guides and Running the Projects

- [Java, Sbt and Chisel Guide](https://docs.google.com/document/d/13pX-4cFuGuj_i7VRhmksyf7YL6-qXiF8-O9J9m_yVfI/edit?usp=sharing)
- [GTKWave Guide](https://docs.google.com/document/d/1-muYy8XSGP4EbMIbLuwTEscIj1UC-u8HU5glcBpIFUo/edit?usp=sharing)
- [Vivado Guide](https://docs.google.com/document/d/1O-y1rnS1V_Bjyc2GwYd9C6Gq1IsqVcxacy2lTD6tHME/edit?usp=sharing)






*version 9.1 3406098903
u 247
V? 2
R? 5
? 5
D? 9
C? 2
@libraries
@analysis
.TRAN 1 0 0 0
+0 0ns
+1 5ms
@targets
@attributes
@translators
a 0 u 13 0 0 0 hln 100 PCBOARDS=PCB
a 0 u 13 0 0 0 hln 100 PSPICE=PSPICE
a 0 u 13 0 0 0 hln 100 XILINX=XILINX
@setup
unconnectedPins 0
connectViaLabel 0
connectViaLocalLabels 0
NoStim4ExtIFPortsWarnings 1
AutoGenStim4ExtIFPorts 1
@index
pageloc 1 0 4230 
@status
n 2453 123:04:22:00:45:02;1684694702 e 
s 2832 123:04:22:00:45:06;1684694706 e 
c 123:04:22:00:45:00;1684694700
*page 1 0 970 720 iA
@ports
port 18 GND_EARTH 570 0 h
port 16 GND_EARTH 480 280 h
@parts
part 2 VSIN 330 180 h
a 1 u 0 0 0 0 hcn 100 VOFF=0
a 1 u 0 0 0 0 hcn 100 VAMPL=12
a 0 a 0:13 0 0 0 hln 100 PKGREF=V1
a 1 ap 9 0 20 0 hcn 100 REFDES=V1
a 1 u 0 0 0 0 hcn 100 FREQ=400
a 1 u 0 0 0 0 hcn 100 AC=5
part 3 r 650 270 v
a 0 sp 0 0 0 10 hlb 100 PART=r
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=R1
a 0 ap 9 0 15 0 hln 100 REFDES=R1
a 0 u 13 0 15 30 hln 100 VALUE=1k
part 25 D1N4002 380 220 h
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=DO-41
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=D3
a 0 ap 9 0 17 4 hln 100 REFDES=D3
a 0 sp 11 0 7 29 hln 100 PART=D1N4002
part 23 D1N4002 380 150 h
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=DO-41
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=D1
a 0 ap 9 0 17 4 hln 100 REFDES=D1
a 0 sp 11 0 17 -11 hln 100 PART=D1N4002
part 203 D1N750 620 240 v
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=DO-35
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=D8
a 0 ap 9 0 15 0 hln 100 REFDES=D8
a 0 sp 11 0 35 40 hln 100 PART=D1N750
part 27 D1N4002 500 220 h
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=DO-41
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=D5
a 0 ap 9 0 17 4 hln 100 REFDES=D5
a 0 sp 11 0 -3 29 hln 100 PART=D1N4002
part 26 D1N4002 490 150 h
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=DO-41
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=D4
a 0 ap 9 0 17 4 hln 100 REFDES=D4
a 0 sp 11 0 7 -6 hln 100 PART=D1N4002
part 129 c 570 240 v
a 0 sp 0 0 0 10 hlb 100 PART=c
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=CK05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=C1
a 0 ap 9 0 15 0 hln 100 REFDES=C1
a 0 u 13 0 -5 5 hln 100 VALUE=470uF
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
part 19 nodeMarker 650 220 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=Out
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=1
part 236 nodeMarker 330 160 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=4
@conn
w 22
a 0 up 0:33 0 0 0 hln 100 V=
s 330 220 330 260 10
s 330 260 470 260 55
a 0 up 33 0 400 259 hct 100 V=
s 470 260 470 220 58
s 410 220 470 220 37
s 470 220 500 220 54
w 80
a 0 up 0:33 0 0 0 hln 100 V=
a 0 sr 0 0 0 0 hln 100 LABEL=In
s 330 160 330 110 237
a 0 sr 3 0 332 135 hln 100 LABEL=In
s 330 180 330 160 104
s 470 110 330 110 46
a 0 up 33 0 400 109 hct 100 V=
s 470 110 470 150 84
s 410 150 470 150 86
s 470 150 490 150 88
w 36
a 0 up 0:33 0 0 0 hln 100 V=
s 650 280 650 270 105
s 620 280 650 280 212
s 620 240 620 280 210
s 370 280 480 280 117
a 0 up 33 0 560 279 hct 100 V=
s 370 180 370 280 68
s 380 180 370 180 65
s 380 150 380 180 35
s 380 180 380 220 67
s 480 280 570 280 119
s 570 240 570 280 140
s 570 280 620 280 142
w 238
a 0 up 0:33 0 0 0 hln 100 V=
a 0 sr 0:3 0 662 220 hln 100 LABEL=Out
s 650 220 650 230 188
a 0 sr 3 0 662 220 hln 100 LABEL=Out
s 620 180 620 210 204
s 620 180 650 180 207
s 650 180 650 220 102
a 0 up 33 0 662 221 hlt 100 V=
s 570 180 570 210 132
s 530 180 570 180 189
a 0 up 33 0 580 179 hct 100 V=
s 530 220 530 180 39
s 530 180 530 150 224
s 530 150 520 150 41
s 570 180 620 180 245
@junction
j 410 220
+ p 25 2
+ w 22
j 470 220
+ w 22
+ w 22
j 410 150
+ p 23 2
+ w 80
j 470 150
+ w 80
+ w 80
j 490 150
+ p 26 1
+ w 80
j 500 220
+ p 27 1
+ w 22
j 380 180
+ w 36
+ w 36
j 650 270
+ p 3 1
+ w 36
j 650 230
+ p 3 2
+ w 238
j 650 220
+ p 19 pin1
+ w 238
j 620 210
+ p 203 2
+ w 238
j 620 240
+ p 203 1
+ w 36
j 380 220
+ p 25 1
+ w 36
j 380 150
+ p 23 1
+ w 36
j 480 280
+ s 16
+ w 36
j 570 240
+ p 129 1
+ w 36
j 620 280
+ w 36
+ w 36
j 570 280
+ w 36
+ w 36
j 530 180
+ w 238
+ w 238
j 330 160
+ p 236 pin1
+ w 80
j 330 180
+ p 2 +
+ w 80
j 330 220
+ p 2 -
+ w 22
j 620 180
+ w 238
+ w 238
j 530 220
+ p 27 2
+ w 238
j 520 150
+ p 26 2
+ w 238
j 570 210
+ p 129 2
+ w 238
j 570 180
+ w 238
+ w 238
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics

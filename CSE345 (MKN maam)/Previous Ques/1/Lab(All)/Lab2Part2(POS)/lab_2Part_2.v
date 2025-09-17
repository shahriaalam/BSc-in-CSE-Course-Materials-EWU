module lab_2Part_2(input A, B,C,D, output F);
wire w1, w2;
or 
g1(w1,A,B),
g2(w2,A,C);
and
g3(F,w1,w2);
endmodule

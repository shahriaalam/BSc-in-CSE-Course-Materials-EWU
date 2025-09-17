module lab_2Part_1(input A, B,C,D, output F);
wire w1, w2;
and 
g1(w1,B,C);
or
g2(F,w1,A);
endmodule

module 
lab1_p2(input A, B,C, output S);
wire w1, w2,w3,w4;
and g1(w1,~A,~B,C),
g2(w2,~A,B,~C),
g3(w3,A,~B,~C),
g4(w4,A,B,C);
or g5(S,w1,w2,w3,w4);
endmodule
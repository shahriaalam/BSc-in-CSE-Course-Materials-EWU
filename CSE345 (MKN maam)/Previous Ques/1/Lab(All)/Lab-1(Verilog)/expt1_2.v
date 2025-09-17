module expt1_2(input A, B, output S);
wire w1, w2;
and g1(w1,~A,B),
g2(w2,A,~B);
or g3(S,w1,w2);
endmodule
module lab3_part2
(input A,B,C, output S);
assign
S = (~A&~B&C) |
    (~A&B&~C) |
    (A&~B&~C) |
    (A&B&C);
endmodule

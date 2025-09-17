module Lab5part2 (input A2, A1, A0,
				output O0, O1, O2, O3, O4, O5, O6, O7);

assign O0 = (A2 | A1 | A0),
       O1 = (A2 | A1 | ~A0),
       O2 = (A2 | ~A1| A0),
       O3 = (A2 | ~A1| ~A0),
       O4 = (~A2 | A1 | A0),
       O5 = (~A2 | A1 | ~A0),
       O6 = (~A2 | ~A1 | A0),
       O7 = (~A2 | ~A1 | ~A0);
       
endmodule
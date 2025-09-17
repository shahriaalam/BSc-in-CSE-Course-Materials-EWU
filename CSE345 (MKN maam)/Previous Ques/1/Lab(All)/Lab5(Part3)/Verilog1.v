module Lab5part3 (input A2, A1, A0,
				output reg O7,O6,O5,O4,O3,O2,O1,O0);
				
	always @(A2, A1, A0) begin 
	 O0 = 1;
	 O1 = 1;
	 O2 = 1;
	 O3 = 1;
	 O4 = 1;
	 O5 = 1;
	 O6 = 1;
	 O7 = 1;
	 if(~A2 & ~A1 & ~A0) O0 = 0;
	 if(~A2 & ~A1 & A0) O1 = 0;
	 if(~A2 & A1 & ~A0) O2 = 0;
	 if(~A2 & A1 & A0) O3 = 0;
	 if(A2 & ~A1 & ~A0) O4 = 0;
	 if(A2 & ~A1 & A0) O5 = 0;
	 if(A2 & A1 & ~A0) O6 = 0;
	 if(A2 & A1 & A0) O7 = 0;
	end
endmodule

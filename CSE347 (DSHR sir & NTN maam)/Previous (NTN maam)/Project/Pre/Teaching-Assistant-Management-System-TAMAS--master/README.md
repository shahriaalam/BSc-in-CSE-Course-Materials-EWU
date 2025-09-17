<h1>
TAMAS Teaching Management System
</h1>

<h3>
TAMAS to do list
</h3>


<ol>
<h4>For android:</h4> 
<li> Add a JobPostingController class (contruct a jobapplication object from view and perform validation) </li>
<li> Add a studentcontroller class ( construct a student obejct from registeration information and send to db </li>
<li> Fix android job view posting page (when clicked the app crashes </li>
<li> Add a textview to the apply for job page that display job informatiopn </li> 
<li> Remove link from main page to the "submit job posting page ( it was for testing ) </li>
<h4>For desktop</h4>
<li> Implement a simple view ( with three buttons, "Go to instructor login", "ECEadmin login", "Go to student login" )</li>
<li> Implement view for ECEadmin, should have a 1. option to load class allocation information from a file ( file will be in json format (can directly export from sql), james will write the parser 2. a log in page </li>
<li> Implement ECEadmin controller, InstructorController, StudentController ( we can combine them into one controller ) </li>
<li> For every controller we will need a Junit test, use the template under test pacakge </li>
<li> implement the build.xml </li>
<h4> For web </h4>
<li> Login page </li>
<li> Refactor the code to use model </li>
<li> Implement PHPunit test </li>
<li> Input validation code to prevent sql injection </li>
</ol>


<p>
The management of TAs and graders contributing to courses offered by ECE is a carried out before the beginning of each semester by first uploading the list of courses for the upcoming semester with detailed course information (e.g. course credit, number of lab and tutorial sessions and hours) and student enrolment data. This information defines the default TA and grader hours calculated by the department, which implicitly specify a budget for the course derived using different hourly rates for TAs and graders. </p><br>
<p>Instructors of each course publish job postings for TA and grader positions by a given deadline by specifying the preferred skills and experience required for the course. Both graduate and undergraduate students may apply to at most three job offers by submitting their personal details (e.g. McGill ID number) and their past TA/grader experience and specifying their preference between the different courses. A student may apply for both TA and grader positions for a course.</p> <br>
<p>The department prepares an initial allocation considering that (1) the same TA should be hired whenever possible for classes with multiple tutorial or lab sessions, (2) each TA may have an appointment of at least 45 hours (for each course) and at most 180 hours (in total), and (3) if graduate TAs are available for a course then they should be hired instead of undergraduate students. Instructors may modify this initial allocation by changing TA and grader hours if the total budget of the course is not exceeded. </p><br>
<p>The department approves the final TA and grader allocations for each course and sends the job offers to the TAs and graders who can accept or reject it. In order to handle unforeseen events and changes, multiple job offers can be sent to TAs and graders by the department. At the end of the course, the instructor writes a short evaluation on each TA and grader of the course. </p><br>

<h1>Work Plan and Progress</h1>
<p dir="ltr">Meeting 1: Sunday 2/5/17, 3:00 PM - 5:30 PM, Trottier Building (2.5h)</p>
<br>
<p dir="ltr">Attendance:</p>
<p dir="ltr">Ebou Jobe</p>
<p dir="ltr">Wiam El Ouadi</p>
<p dir="ltr">Bijan Sadeghi</p>
<p dir="ltr">Younes Boubekeur</p>
<p dir="ltr">James Tang</p>
<br>
<p dir="ltr">Key Design decisions </p>
<p dir="ltr">No specific design decisions were made.</p>
<br>
<p dir="ltr">Task Distribution </p>
<p dir="ltr">1. Collectively looked over project description (All)</p>
<p dir="ltr">2. Collectively studied the requirements of the project (All)</p>
<p dir="ltr">3. Addressed some questions regarding the deliverable #1 (All)</p>
<p dir="ltr">4. Set up meeting times for future meetings (All)</p>
<p dir="ltr">5. Created meeting log (All)</p>
<p dir="ltr">6. Set up Github access (All)</p>
<br>
<p dir="ltr">======================================================================</p>
<br>
<p dir="ltr">Meeting 2: Monday 2/6/2017, 4:00 PM - 9:00 PM, McLennan Library (5h)</p>
<br>
<p dir="ltr">Attendance</p>
<p dir="ltr">Ebou Jobe</p>
<p dir="ltr">Wiam El Ouadi</p>
<p dir="ltr">Bijan Sadeghi</p>
<p dir="ltr">Younes Boubekeur</p>
<p dir="ltr">James Tang</p>
<br>
<p dir="ltr">Key Design decisions </p>
<p dir="ltr">TA will not leave job throughout the semester. </p>
<p dir="ltr">Lab sessions and tutorial sessions will not overlap each other.</p>
<br>
<p dir="ltr">Task Distribution </p>
<p dir="ltr">1. Discussed design questions and general project specifications (All)</p>
<p dir="ltr">2. Began working on requirements document (Bijan &amp; Ebou)</p>
<p dir="ltr">3. Worked on functional/nonfunctional requirements &nbsp;(Wiam, Younes, James &amp; Bijan)</p>
<p dir="ltr">4. Worked on actors and use cases (Bijan &amp; Ebou)</p>
<p dir="ltr">5. Continued working on domain model (All)</p>
<p dir="ltr">6. Address more questions regarding the remaining parts of the deliverable #1 (All)</p>
<br>
<p dir="ltr">======================================================================</p>
<br>
<p dir="ltr">Meeting 3: Wednesday 2/8/2017, 5 PM - 9:30 PM, McLennan Library &nbsp;&nbsp;&nbsp;(4.5h)</p>
<br>
<p dir="ltr">Attendance</p>
<p dir="ltr">Ebou Jobe</p>
<p dir="ltr">Wiam El Ouadi</p>
<p dir="ltr">Bijan Sadeghi</p>
<p dir="ltr">Younes Boubekeur</p>
<p dir="ltr">James Tang</p>
<br>
<br>
<p dir="ltr">Key Design decisions </p>
<p dir="ltr">Created the first draft of the Class Diagram, including multiplicities. For example, we decided an Instructor can teach many Courses, and a Course may be given by more than one Instructor. We created the classes JobApplication, Allocation, JobAssignment.</p>
<br>
<p dir="ltr">Task Distribution </p>
<ol>
<li dir="ltr">
<p dir="ltr">Worked on domain model (All)</p>
</li>
<li dir="ltr">
<p dir="ltr">Almost finished statechart for class &ldquo;Job&rdquo; &nbsp;(Wiam, Younes &amp; James)</p>
</li>
<li dir="ltr">
<p dir="ltr">Begin requirement-level sequence/activity diagrams (All)</p>
</li>
<li dir="ltr">
<p dir="ltr">Updated meeting log (All)</p>
</li>
</ol>
<br>
<p dir="ltr">======================================================================</p>
<br>
<p dir="ltr">Meeting 4: Saturday 2/11/2017, 3 PM - 2 AM, Trottier (11h)</p>
<br>
<p dir="ltr">Attendance</p>
<p dir="ltr">Ebou Jobe</p>
<p dir="ltr">Wiam El Ouadi</p>
<p dir="ltr">Bijan Sadeghi</p>
<p dir="ltr">Younes Boubekeur</p>
<p dir="ltr">James Tang</p>
<br>
<p dir="ltr">Key Design decisions </p>
<p dir="ltr">Replaced GradStudent and UndergradStudent subclasses with a boolean isGrad attribute in the Student class. Redefined the relationship between Allocation and the other classes, and updated multiplicities from * to 0..3. Added studentEnrolment attribute in the Course class. TAMAS doesn&rsquo;t choose the final candidate for the position but proposes eligible ones based on their availabilities and student status. The instructor is the one that chooses the optimal candidate and enters it in TAMAS so that the EceAdmin can approve it.</p>
<br>
<p dir="ltr">Task Distribution </p>
<p dir="ltr">1. Revised and advanced domain model based on discussions </p>
<p dir="ltr">2. Completed requirements-level sequence diagrams</p>
<p dir="ltr">3. Discussed in detail regarding the sequence diagrams</p>
<p dir="ltr">4. Updated meeting log </p>
<br>
<p dir="ltr">======================================================================</p>
<br>
<p dir="ltr">Meeting 5: Sunday 2/12/2017, 1 PM - 3 PM, Trottier (2h)</p>
<br>
<p dir="ltr">Attendance</p>
<p dir="ltr">Ebou Jobe</p>
<p dir="ltr">Wiam El Ouadi</p>
<p dir="ltr">Bijan Sadeghi</p>
<p dir="ltr">Younes Boubekeur</p>
<p dir="ltr">James Tang</p>
<br>
<p dir="ltr">Key Design decision </p>
<p dir="ltr">No specific design decisions were made.</p>
<br>
<p dir="ltr">Task Distribution </p>
<p dir="ltr">1. Finished domain model and added it to document</p>
<p dir="ltr">2. Finished use case diagram and descriptions</p>
<p dir="ltr">3. Finished statechart</p>
<p dir="ltr">4. Formatted document</p>
<p dir="ltr">5. Updated meeting log </p>
<br>
<p dir="ltr">======================================================================</p>
<br>
<p dir="ltr">Member Contribution up to deliverable #1 </p>
<p dir="ltr">Bijan: 22h</p>
<p dir="ltr">Ebou: 22h </p>
<p dir="ltr">Younes: 22h</p>
<p dir="ltr">Wiam: 22h</p>
<p dir="ltr">James: 22h &nbsp;</p>
======================================================================<br>
<p dir="ltr"></p>
<p dir="ltr">Proposed work plan for remaining Iterations </p>
<br>
<p dir="ltr">Deliverable 2, due Feb 26th, Sunday</p>
<p dir="ltr"> </p>
<p dir="ltr">Proposed meeting time and hours</p>
<p dir="ltr">Meeting #1: Wed, Feb, 15th. 5:00pm-9:30pm ( 4.5 h) </p>
<p dir="ltr">Meeting #2: Sat, Feb, 18th. 12:00pm-10:00pm ( 10 h) </p>
<p dir="ltr">Meeting #3: Thur, Feb 23rd 6:00pm-10:00pm ( 4 h) </p>
<p dir="ltr">Meeting #4: Sat, 25th. 12:00pm-10:00pm ( 10 h) </p>
<br>
<p dir="ltr">Requirements to be addressed: </p>
<br>
<p dir="ltr">TAMAS Functional Requirements</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TFR.01</p></td>
<td><p dir="ltr">TAMAS shall determine default TA and grader hours based on a list of courses uploaded by the department that includes key course information.</p></td>
</tr>
<tr>
<td><p dir="ltr">TFR.02</p></td>
<td><p dir="ltr">TAMAS shall allow instructors to publish job postings for upcoming TAs and markers until a given deadline.</p></td>
</tr>
<tr>
<td><p dir="ltr">TFR.03</p></td>
<td><p dir="ltr">TAMAS shall allow students to apply to at most three unique jobs by submitting their applicant details (including the possibility of applying to a TA and grader job for the same course).</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">TAMAS Non-Functional Requirements</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TNR.01</p></td>
<td><p dir="ltr">TAMAS shall be accessible on Desktop (full functionality), Web and Android (one each for TAs and instructors, in any order). </p></td>
</tr>
<tr>
<td><p dir="ltr">TNR.02</p></td>
<td><p dir="ltr">TAMAS shall prompt users to verify their identity in order to access the appropriate functionality.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Estimating of efforts</p>
<ul>
<li dir="ltr">
<p dir="ltr">Description of architecture of proposed solution including block diagrams ( 4h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Description of detailed design of proposed solution including class diagrams ( 9-10h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Source &nbsp;code of &nbsp;prototype &nbsp;implementation &nbsp;of &ldquo;Publish Job Posting&rdquo; &nbsp;use case &nbsp;on Java &nbsp;and mobile/web platform and &ldquo;Apply for Job&rdquo; use case on Java and web/mobile platform. ( 9-10h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Implementation-level sequence &nbsp;diagram for &ldquo;Publish Job Posting&rdquo; and &ldquo;Apply for Job&rdquo; use &nbsp;cases for each supported platform ( 3 h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Update of work plan (1 h)</p>
</li>
</ul>
======================================================================
<p dir="ltr">Deliverable 3, due March 17th, Friday</p>
<p dir="ltr"> </p>
<p dir="ltr">Proposed meeting time and hours</p>
<p dir="ltr">Meeting #1: Wed, March 1st. 5pm-9:00pm ( 4 h) </p>
<p dir="ltr">Meeting #2: Sat, March 4th, 12:00pm-10:00pm ( 10 h) </p>
<p dir="ltr">Meeting #3: Thursday March 9th. 5:00pm-10:00pm ( 6 h)</p>
<p dir="ltr">Meeting #4: Thursday March 15th. 6:00pm-10:00pm ( 4 h)</p>
<br>
<p dir="ltr">Requirements to be addressed: </p>
<br>
<p dir="ltr">Functional</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TFR.04</p></td>
<td><p dir="ltr">TAMAS shall determine the optimal candidate for each available job based on their availabilities and their student status.</p></td>
</tr>
<tr>
<td><p dir="ltr">TFR.05</p></td>
<td><p dir="ltr">TAMAS shall allow instructors to change the initial allocation of worker hours in the case that the budget is not exceeded.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Non- Functional</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TNR.02</p></td>
<td><p dir="ltr">TAMAS shall prompt users to verify their identity in order to access the appropriate functionality.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Estimating of efforts</p>
<ul>
<li dir="ltr">
<p dir="ltr">Description of unit testing ( 6 h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Description of component testing ( 6h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Description of system testing ( 7 h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Description of performance/stress testing ( 4h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Update of work plan (1h)</p>
</li>
</ul>
<br>
======================================================================<br>
<p dir="ltr">Deliverable 4, due March 27, Monday</p>
<p dir="ltr"> </p>
<p dir="ltr">Proposed meeting time and hours</p>
<p dir="ltr">Meeting #1: Sat,March 18th. 12:00pm-10:00pm ( 10 h) </p>
<p dir="ltr">Meeting #2: Wed, March 22nd. 5:00pm-9:30pm ( 4.5 h) </p>
<p dir="ltr">Meeting #3: Sat, March 25th 12:00pm-10:00pm ( 10 h) </p>
<br>
<p dir="ltr">Functional</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TFR.06</p></td>
<td><p dir="ltr">TAMAS shall allow the department to approve final job allocations.</p></td>
</tr>
<tr>
<td><p dir="ltr">TFR.07</p></td>
<td><p dir="ltr">TAMAS shall prompt selected students to accept or reject job offers.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Non- Functional</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TNR.03</p></td>
<td><p dir="ltr">TAMAS shall require less than 30 minutes of training time for users to learn how to use all features of the system.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Estimating of efforts</p>
<ul>
<li dir="ltr">
<p dir="ltr">Adding TNR.03, TRF.06 and TF.07 to TAMAS ( 13h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Description of release pipeline ( 9-10h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Update of work plan (1h)</p>
</li>
</ul>
======================================================================<br>
<p dir="ltr">Deliverable 5, due April 3rd, Monday</p>
<p dir="ltr"> </p>
<p dir="ltr">Proposed meeting time and hours</p>
<p dir="ltr">Meeting #1: Wed,March 29th. 5:00pm-10:00pm ( 5 h) </p>
<p dir="ltr">Meeting #2: Thursday, March 30th. 5:00pm-9:30pm ( 4.5 h) </p>
<p dir="ltr">Meeting #3: Sat, April 1st, 12:00pm-10:00pm ( 10 h)</p>
<p dir="ltr">Meeting #4: Sun, April 2nd, 10:00am-4:00pm (6h)</p>
<br>
<p dir="ltr">Functional</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TFR.08</p></td>
<td><p dir="ltr">TAMAS shall allow the instructor to submit an evaluation for each TA and grader at the end of the course.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Non- Functional</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TNR.04</p></td>
<td><p dir="ltr">TAMAS shall perform each of its operations in less than one minute.</p></td>
</tr>
<tr>
<td><p dir="ltr">TNR.05</p></td>
<td><p dir="ltr">TAMAS shall take less than 500 MB of disk space.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Estimating of efforts</p>
<ul>
<li dir="ltr">
<p dir="ltr">Adding requirements TFR.08, TNR.04, TNR.05 to TAMAS (5h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Getting TAMAS ready for presentation ( 6h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Improve UI ( 4h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Preparing for presentation ( 8h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Update of work plan (1h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Presentation ( 0.5h)</p>
</li>
</ul>
<br>
======================================================================<br>
<p dir="ltr">Deliverable 6, due April 11th, Monday</p>
<p dir="ltr"> </p>
<p dir="ltr">Proposed meeting time and hours</p>
<p dir="ltr">Meeting #1: Wed, April 5th. 5:00pm-10:00pm ( 5 h) </p>
<p dir="ltr">Meeting #2: Thursday,April 6th. 5:00pm-9:30pm ( 4.5 h) </p>
<p dir="ltr">Meeting #3: Sat, April 8th, 12:00pm-10:00pm ( 10 h)</p>
<p dir="ltr">Meeting #4: Sun, April 9th, 11:00am-4:00pm (5h) </p>
<br>
<p dir="ltr">Non- Functional</p>
<br>
<div dir="ltr">
<table>
<colgroup>
<col width="108">
<col width="492">
</colgroup>
<tr>
<td><p dir="ltr">TNR.06</p></td>
<td><p dir="ltr">TAMAS shall have no more than two malfunctions per session of use.</p></td>
</tr>
<tr>
<td><p dir="ltr">TNR.07</p></td>
<td><p dir="ltr">TAMAS shall force-close at a rate less than one out of twenty sessions.</p></td>
</tr>
</table>
</div>
<br>
<p dir="ltr">Estimating of efforts</p>
<ul>
<li dir="ltr">
<p dir="ltr">Improve UI ( 4h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Ensure requirement TNR.06, TNR.07 are met. ( 4h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Optimize TAMAS for performance ( 4h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Gather source code of full implementation of TAMAS ( 2h)</p>
</li>
<li dir="ltr">
<p dir="ltr">Gather full commit history of the Github repository (1h)</p>
</li>
</ul>


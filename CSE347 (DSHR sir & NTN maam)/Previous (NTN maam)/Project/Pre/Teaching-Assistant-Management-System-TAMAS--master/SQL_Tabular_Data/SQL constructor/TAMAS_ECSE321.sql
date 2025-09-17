-- phpMyAdmin SQL Dump
-- version 4.0.10.14
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Apr 02, 2017 at 12:59 PM
-- Server version: 5.6.33-cll-lve
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `TAMAS_ECSE321`
--

-- --------------------------------------------------------

--
-- Table structure for table `ApplicationData`
--

CREATE TABLE IF NOT EXISTS `ApplicationData` (
  `APPLICANT_ID` int(10) NOT NULL,
  `JOB_POSTING_ID` int(10) NOT NULL,
  `APPLICANT_FNAME` varchar(30) NOT NULL,
  `APPLICANT_LNAME` varchar(30) NOT NULL,
  `APPLICANT_EMAIL` varchar(40) NOT NULL,
  `STATUS` varchar(20) NOT NULL,
  `CV` text NOT NULL,
  PRIMARY KEY (`APPLICANT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ApplicationData`
--

INSERT INTO `ApplicationData` (`APPLICANT_ID`, `JOB_POSTING_ID`, `APPLICANT_FNAME`, `APPLICANT_LNAME`, `APPLICANT_EMAIL`, `STATUS`, `CV`) VALUES
(930182231, 3, 'Katherine', 'Watkins', 'kwatkins@ece.mcgill.com', 'UGRAD', 'Experience of the student2'),
(12320, 230120, 'Jack', 'Zhu', 'jackzhu@gmail.com', 'Ugrad', 'This is jack'),
(99999, 11111, 'Bob', 'Smith', 'bob.smith@mail.mcgill.ca', 'UGRAD', 'CV'),
(12345643, 34431413, 'Bob', 'Cool', 'email.com', 'UGRAD', 'CV'),
(32103910, 23127301, 'Mark', 'Young', 'mark.young@mail.mcgill.ca', 'UGRAD', 'I am interested in applying! Experience:TA for ECSE222 and I am a graduate student.');

-- --------------------------------------------------------

--
-- Table structure for table `CourseData`
--

CREATE TABLE IF NOT EXISTS `CourseData` (
  `COURSE_CODE` varchar(10) NOT NULL,
  `COURSE_CREDIT` int(5) NOT NULL,
  `COURSE_BUDGET` int(7) NOT NULL,
  `COURSE_HOUR` int(10) NOT NULL,
  `COURSE_ENROLMENT` int(5) NOT NULL,
  `COURSE_SESSION` varchar(40) NOT NULL,
  `COURSE_INSTRUCTOR` varchar(200) NOT NULL,
  UNIQUE KEY `COURSE_CODE` (`COURSE_CODE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CourseData`
--

INSERT INTO `CourseData` (`COURSE_CODE`, `COURSE_CREDIT`, `COURSE_BUDGET`, `COURSE_HOUR`, `COURSE_ENROLMENT`, `COURSE_SESSION`, `COURSE_INSTRUCTOR`) VALUES
('ECSE200', 3, 2000, 40, 100, '', 'Thomas_Szkopek'),
('ECSE202', 3, 1800, 40, 78, '', 'David_Lowther'),
('ECSE205', 3, 1400, 40, 13, '', 'Steve_McFee'),
('ECSE206', 3, 2000, 40, 132, '', 'Lawrence_Chen'),
('ECSE210', 3, 2400, 36, 60, '', 'Martin_Levine'),
('ECSE211', 3, 2000, 40, 141, '', 'David_Lowther Frank_Ferrie'),
('ECSE222', 3, 2000, 40, 113, '', 'Aditya_Mahajan'),
('ECSE223', 3, 2300, 40, 124, '', 'Gunter_Mussbacher'),
('ECSE251', 3, 2000, 40, 130, '', 'Dennis_Giannacopoulos'),
('ECSE324', 4, 2500, 45, 89, '', 'Derek_Nowrouzezahrai'),
('ECSE539', 4, 2000, 40, 30, '', 'Gunter_Mussbacher'),
('ECSE321', 3, 3000, 40, 120, '', 'Daniel_Varro'),
('ECSE330', 3, 2500, 40, 60, '', 'David_Plant'),
('ECSE428', 3, 1600, 44, 87, '', 'Aditya_Mahajan Daniel_Varro'),
('ECSE421', 3, 2450, 40, 30, '', 'Jeremy_Cooperstock');

-- --------------------------------------------------------

--
-- Table structure for table `InstructorRecord`
--

CREATE TABLE IF NOT EXISTS `InstructorRecord` (
  `USERNAME` varchar(40) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL,
  `FNAME` varchar(40) NOT NULL,
  `LNAME` varchar(40) NOT NULL,
  `EVALUATION` text NOT NULL,
  `COURSE` text NOT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InstructorRecord`
--

INSERT INTO `InstructorRecord` (`USERNAME`, `PASSWORD`, `FNAME`, `LNAME`, `EVALUATION`, `COURSE`) VALUES
('dlowther@mcgill.ca', 'dlowther123', 'David', 'Lowther', '', 'ECSE202 ECSE211'),
('tszkopek@mcgill.ca', 'tszkopek123', 'Thomas', 'Szkopek', '', 'ECSE200'),
('fferrie@mcgill.ca', 'fferrie123', 'Frank', 'Ferrie', '', 'ECSE211'),
('apakniyat@mcgill.ca', 'apakniyat123', 'Ali', 'Pakniyat', '', ''),
('lchen@mcgill.ca', 'lchen123', 'Lawrence', 'Chen', '', 'ECSE206'),
('mlevine@mcgill.ca', 'mlevine123', 'Martin', 'Levine', '', 'ECSE210'),
('smcfee@mcgill.ca', 'smcfee123', 'Steve', 'McFee', '', 'ECSE205'),
('amahajan@mcgill.ca', 'amahajan123', 'Aditya', 'Mahajan', '', 'ECSE222 ECSE428'),
('gmussbacher@mcgill.ca', 'ilovesequencediagrams', 'Gunter', 'Mussbacher', '', 'ECSE223 ECSE539'),
('dgiannacopoulos@mcgill.ca', 'dgiannacopoulos123', 'Dennis', 'Giannacopoulos', '', 'ECSE251'),
('dnowrouzezahrai@mcgill.ca', 'dnowrouzezahrai123', 'Derek', 'Nowrouzezahrai', '', 'ECSE324'),
('dvarro@mcgill.ca', 'dvarro123', 'Daniel', 'Varro', '', 'ECSE321 ECSE428'),
('dplant@mcgill.ca', 'dplant123', 'David', 'Plant', '', 'ECSE330'),
('jcooperstock@mcgill.ca', 'jcooperstock123', 'Jeremy', 'Cooperstock', '', 'ECSE421'),
('dmeger@mcgill.ca', 'dmeger123', 'David', 'Meger', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `JobPostData`
--

CREATE TABLE IF NOT EXISTS `JobPostData` (
  `POST_ID` int(10) NOT NULL AUTO_INCREMENT,
  `INSTRUCTOR_NAME` varchar(100) NOT NULL,
  `COURSE` varchar(20) NOT NULL,
  `JOB_TYPE` varchar(10) NOT NULL,
  `HOUR` int(10) NOT NULL,
  `DESCRIPTION` text NOT NULL,
  `ASSIGNED_TO_STUDENT` varchar(40) DEFAULT NULL,
  `ALLOCATED_TO_STUDENT` varchar(40) DEFAULT NULL,
  `DAYS_OF_WEEK` varchar(100) NOT NULL,
  `MON_START_TIME` int(10) NOT NULL,
  `MON_END_TIME` int(10) NOT NULL,
  `TUE_START_TIME` int(10) NOT NULL,
  `TUE_END_TIME` int(10) NOT NULL,
  `WED_START_TIME` int(10) NOT NULL,
  `WED_END_TIME` int(10) NOT NULL,
  `THU_START_TIME` int(10) NOT NULL,
  `THU_END_TIME` int(10) NOT NULL,
  `FRI_START_TIME` int(10) NOT NULL,
  `FRI_END_TIME` int(10) NOT NULL,
  PRIMARY KEY (`POST_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=248 ;

--
-- Dumping data for table `JobPostData`
--

INSERT INTO `JobPostData` (`POST_ID`, `INSTRUCTOR_NAME`, `COURSE`, `JOB_TYPE`, `HOUR`, `DESCRIPTION`, `ASSIGNED_TO_STUDENT`, `ALLOCATED_TO_STUDENT`, `DAYS_OF_WEEK`, `MON_START_TIME`, `MON_END_TIME`, `TUE_START_TIME`, `TUE_END_TIME`, `WED_START_TIME`, `WED_END_TIME`, `THU_START_TIME`, `THU_END_TIME`, `FRI_START_TIME`, `FRI_END_TIME`) VALUES
(1, 'Proferssor Paul Python', 'ECSE222', 'Marker', 14, 'Offered by: Electrical & Computer Engr (Faculty of Engineering)\r\nOverview\r\n\r\nElectrical Engineering : An introduction to digital logic, binary numbers and Boolean algebra, combinational circuits, optimized implementation of combinational circuits, arithmetic circuits, combinational circuit building blocks, flip-flops, registers, counters, design of digital circuits with VHDL, and synchronous sequential circuits', NULL, NULL, 'Monday Tuesday Thursdsday', 800, 900, 800, 900, 800, 800, 800, 1000, 800, 800),
(2, 'Proferssor Paul Python', 'ECSE223', 'Grader', 15, 'Electrical Engineering : Integration of modelling with programming; abstraction in software engineering; structural modelling; state-based modelling; modelling of object-oriented systems, code generation; natural language constraints in modelling notations; architectural and design patterns; integrated development environments; programming tools (debugging, continuous build/integration, version control and code repositories, diff, defect and issue tracking, refactoring); code review processes.\r\n\r\nTerms: Winter 2017\r\n\r\nInstructors: Gunter Mussbacher (Winter) ', NULL, NULL, 'Tuesday Wednesday', 800, 800, 800, 800, 900, 900, 800, 800, 800, 800),
(3, 'Proferssor Paul Python', 'ECSE223', 'Marker', 20, 'Overview\r\n\r\nElectrical Engineering : Integration of modelling with programming; abstraction in software engineering; structural modelling; state-based modelling; modelling of object-oriented systems, code generation; natural language constraints in modelling notations; architectural and design patterns; integrated development environments; programming tools (debugging, continuous build/integration, version control and code repositories, diff, defect and issue tracking, refactoring); code review processes.\r\n\r\nTerms: Winter 2017\r\n\r\nInstructors: Gunter Mussbacher (Winter) ', NULL, NULL, 'Tuesday Wednesday', 800, 800, 800, 900, 800, 900, 800, 800, 800, 800),
(4, 'Proferssor Paul Python', 'ECSE222', 'Grader', 20, 'Overview\r\n\r\nElectrical Engineering : Design, development and testing of software systems. Software life cycle: requirements analysis, software architecture and design, implementation, integration, test planning, and maintenance. The course involves a group project.\r\n\r\nTerms: Fall 2016, Winter 2017 ', NULL, NULL, 'Wednesday Thursdsday', 800, 800, 800, 800, 800, 1600, 900, 1300, 800, 800),
(5, 'Proferssor Paul Python', 'ECSE321', 'Marker', 20, 'Overview\r\n\r\nElectrical Engineering : Design, development and testing of software systems. Software life cycle: requirements analysis, software architecture and design, implementation, integration, test planning, and maintenance. The course involves a group project.\r\n\r\nTerms: Fall 2016, Winter 2017 ', NULL, NULL, 'Wednesday Thursdsday', 800, 800, 800, 800, 800, 1000, 800, 1000, 800, 800),
(8, 'James McGill', 'ECSE333', 'GRADER', 20, 'This is a cool class', NULL, NULL, 'Monday Tuesday', 800, 800, 1000, 800, 900, 800, 900, 900, 1000, 1100),
(232, 'Proferssor Paul Python', 'ECSE223', 'Marker', 231, 'HIRING!', NULL, NULL, 'Monday Wednesday Thursdsday', 800, 900, 800, 800, 800, 1000, 800, 1200, 800, 800),
(233, 'Proferssor Paul Python', 'ECSE321', 'Grader', 23, 'HIRING!', NULL, NULL, 'Wednesday Thursdsday', 800, 800, 800, 800, 800, 900, 800, 1000, 800, 800),
(234, 'Proferssor Paul Python', 'ECSE222', 'Marker', 23, 'HIRING!', NULL, NULL, 'Wednesday Thursdsday Friday', 800, 800, 800, 800, 800, 800, 800, 800, 800, 800),
(235, 'DANIEL VARRO', 'ECSE 222', 'Grader', 800, 'Grade weekly written assignments, midterm exam, and final exam.', NULL, NULL, 'Tuesday Wednesday ', 8, 8, 8, 10, 9, 11, 8, 8, 8, 8),
(236, 'DANIEL VARRO', 'ECSE 222', 'Grader', 700, 'DIGITAL LOGIC GRADING', NULL, NULL, 'Monday ', 8, 8, 8, 8, 8, 8, 8, 8, 8, 8),
(237, 'DANIEL VARRO', 'ECSE 222', 'Grader', 800, 'A COOL JOB', NULL, NULL, 'Tuesday ', 8, 8, 8, 10, 8, 8, 8, 8, 8, 8),
(238, 'DANIEL VARRO', 'ECSE 321', 'Grader', 800, 'huinuiniuonu', NULL, NULL, 'Wednesday ', 8, 8, 8, 8, 8, 8, 8, 8, 8, 8),
(239, 'DANIEL VARRO', 'ECSE222', 'Grader', 800, 'A COOL JOB', NULL, NULL, 'Wednesday Thursday ', 8, 8, 8, 8, 8, 10, 8, 11, 8, 8),
(240, 'DANIEL VARRO', 'ECSE222', 'TA', 800, 'A GREAT JOB', NULL, NULL, 'Thursday ', 8, 8, 8, 8, 8, 8, 8, 10, 8, 8),
(241, 'Gunter Mussbacher', 'ECSE 222', 'TA', 0, '', NULL, NULL, '', 8, 8, 8, 8, 8, 8, 8, 8, 8, 8),
(242, 'Gunter Mussbacher', 'ECSE 222', 'TA', 50, '', NULL, NULL, '', 8, 8, 8, 8, 8, 8, 8, 8, 8, 8),
(243, 'Gunter Mussbacher', 'ECSE 222', 'TA', 50, '', NULL, NULL, '', 8, 8, 8, 8, 8, 8, 8, 8, 8, 8),
(244, 'Gunter Mussbacher', 'ECSE 222', 'TA', 50, '', NULL, NULL, '', 8, 8, 8, 8, 8, 8, 8, 8, 8, 8),
(245, 'Gunter Mussbacher', 'ECSE 222', 'TA', 50, '', NULL, NULL, 'Wednesday ', 8, 8, 8, 8, 8, 8, 8, 8, 8, 8),
(246, 'Gunter Mussbacher', 'ECSE 222', 'TA', 45, '', NULL, NULL, 'Monday ', 8, 10, 8, 8, 8, 8, 8, 8, 8, 8),
(247, 'Gunter Mussbacher', 'ECSE 222', 'TA', 45, '', NULL, NULL, 'Monday ', 8, 9, 8, 8, 8, 8, 8, 8, 8, 8);

-- --------------------------------------------------------

--
-- Table structure for table `StudentRecord`
--

CREATE TABLE IF NOT EXISTS `StudentRecord` (
  `STUDENT_ID` int(10) NOT NULL,
  `FNAME` varchar(40) NOT NULL,
  `LNAME` varchar(40) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL,
  UNIQUE KEY `STUDENT_ID` (`STUDENT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRecord`
--

INSERT INTO `StudentRecord` (`STUDENT_ID`, `FNAME`, `LNAME`, `STATUS`, `EMAIL`, `PASSWORD`) VALUES
(12312030, 'James', 'Java', 'UGRAD', 'Jame.java@java.com', 'jamesjava123'),
(13124, 'James', 'Python', 'UGRAD', 'james.python@mcgill.ca', '1994'),
(12312021, 'James', 'Java', 'UGRAD', 'Jame.java@java.com', 'jamesjava123'),
(294312804, 'Jay', 'Haskell ', 'UGRAD', 'jay.haskell@mcgill.ca', '199701286'),
(235689, 'bob', 'gog', 'UGRAD', 'bobgog@gmail.com', 'chicken'),
(123456789, 'bijan', 'gog', 'UGRAD', 'gkgk', 'gog'),
(222231123, 'Jason', 'Rye', 'UGRAD', 'jason.rye@ece.mcgill.ca', '231092831'),
(872312313, 'james', 'tang', 'UGRAD', 'james@ece.mcgill.ca', '3182-381-2083-01');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

    <?php
    class LocalPersistenceLayer{
    function saveJobPosting(){
        $filename;
        function __construct(){

        }
    }
    function writePostingToFile($course,$hour,$description,$daysofWeek,$timesofWeek){
        // check if the file exists
     echo "writing to file";
       $fh=fopen("data/JobPosting.txt","w") or die("Cannot create or write file");
        // LOCK THE FILE before access

        fwrite($fh, "hello") or die("Could not write to file");

        //close the file after access
        fclose($fh);
    }
    }
    ?>


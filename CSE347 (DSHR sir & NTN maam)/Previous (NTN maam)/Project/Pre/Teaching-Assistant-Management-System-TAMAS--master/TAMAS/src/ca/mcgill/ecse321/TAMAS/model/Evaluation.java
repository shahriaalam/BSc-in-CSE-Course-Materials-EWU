/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-dab6b48 modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.io.Serializable;

/**
 * Should these 3 be here?
 */
// line 59 "../../../../../TAMASPersistence.ump"
// line 19 "../../../../../model.ump"
public class Evaluation implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Evaluation Associations
  private Instructor instructor;
  private Job job;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Evaluation(Instructor aInstructor, Job aJob)
  {
    boolean didAddInstructor = setInstructor(aInstructor);
    if (!didAddInstructor)
    {
      throw new RuntimeException("Unable to create evaluation due to instructor");
    }
    boolean didAddJob = setJob(aJob);
    if (!didAddJob)
    {
      throw new RuntimeException("Unable to create evaluation due to job");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Instructor getInstructor()
  {
    return instructor;
  }

  public Job getJob()
  {
    return job;
  }

  public boolean setInstructor(Instructor aInstructor)
  {
    boolean wasSet = false;
    if (aInstructor == null)
    {
      return wasSet;
    }

    Instructor existingInstructor = instructor;
    instructor = aInstructor;
    if (existingInstructor != null && !existingInstructor.equals(aInstructor))
    {
      existingInstructor.removeEvaluation(this);
    }
    instructor.addEvaluation(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setJob(Job aNewJob)
  {
    boolean wasSet = false;
    if (aNewJob == null)
    {
      //Unable to setJob to null, as evaluation must always be associated to a job
      return wasSet;
    }
    
    Evaluation existingEvaluation = aNewJob.getEvaluation();
    if (existingEvaluation != null && !equals(existingEvaluation))
    {
      //Unable to setJob, the current job already has a evaluation, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Job anOldJob = job;
    job = aNewJob;
    job.setEvaluation(this);

    if (anOldJob != null)
    {
      anOldJob.setEvaluation(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Instructor placeholderInstructor = instructor;
    this.instructor = null;
    placeholderInstructor.removeEvaluation(this);
    Job existingJob = job;
    job = null;
    if (existingJob != null)
    {
      existingJob.setEvaluation(null);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 62 ../../../../../TAMASPersistence.ump
  private static final long serialVersionUID = 386717977557499839L ;

  
}
package com.team1285.frc2016.utilities;
/**
 *
 * @author Marhus Kazi
 * Simple PID Controller that assumes regular loop intervals 
 */
public class PIDController {
    double pGain;
    double iGain;
    double dGain;
    
    double pOut;
    double iOut;
    double dOut;
    
    double error;
    double errorSum = 0;
    double lastError = 0;
    double dProcessVar;
    double maxVal = 0;
    double output = 0;
    
    boolean atTarget = false;
    
    public PIDController(double p, double i, double d) {   
        errorSum = 0;       //initialize errorSum to 0
        lastError = 0;      //initialize lastError to 0 
        pGain = p;
        iGain = i;
        dGain = d;
    }
            
    public void resetIntegral() {
        errorSum = 0.0;
    }
    
    public void resetDerivative() {
       lastError = 0.0;
    }
    
    public void resetPID(){
    	resetIntegral();
    	resetDerivative();
    	atTarget = false;
    	maxVal = 0;
    }
    
    public void changePIDGains(double kP, double kI, double kD) {
        pGain = kP;
        iGain = kI;
        dGain = kD;
    }
    
    public double calcPID(double setPoint, double currentValue, double epsilon) {
        error = setPoint - currentValue;
        
        if(Math.abs(error) <= epsilon){
        	atTarget = true;
        }
        else 
        	atTarget = false;
        
        //P 
        pOut = pGain * error;
        
        //I
        errorSum += error;
        iOut = iGain * errorSum;
        
        //D
        dProcessVar = (error - lastError);
        dOut = dGain * dProcessVar;
        
        lastError = error;
        
        //PID Output
        output = pOut + iOut + dOut;
        
        //Scale output to be between 1 and -1
        if(maxVal < Math.abs(output))
        	maxVal = Math.abs(output);
        
        output = output/maxVal;
        
        return output;
    }
    
    public boolean isDone(){
    	return atTarget;
    }
}	
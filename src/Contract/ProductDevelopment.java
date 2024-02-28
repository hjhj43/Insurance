package Contract;

import java.util.Scanner;

import Insurance.Car;
import Insurance.Fire;
import Insurance.IndustrialAccident;
import Insurance.Insurance;
import Insurance.InsuranceListImpl;
import Insurance.Life;
import Insurance.MedicalHistory;

public class ProductDevelopment {

	private InsuranceListImpl insuranceList;

	@SuppressWarnings("unused")
	private enum insurancePeriod {

	};

   private String guaranteedContent;
   private int insuranceFee;
   private String insuranceTarget;
   private String kindsOfInsurance;
   private int penalty;
   private String restriction;
   public Insurance mInsurance;

   public ProductDevelopment(InsuranceListImpl insuaranceList) {
      this.insuranceList = insuaranceList;
//      Development();
   }

   public boolean Development() {

      Insurance car = new Car();
      Insurance fire = new Fire();
      Insurance IA = new IndustrialAccident();
      Insurance life = new Life();
      Insurance MH = new MedicalHistory();

      System.out.println(
            "Choose the Insurance : 1.Car 2.Fire 3.Industrial Accident 4.Life 5.Medical History of the customer");
      Scanner scan = new Scanner(System.in);
      
      if (scan.nextInt() == 1) {
         make(car);
      } else if (scan.nextInt() == 2) {
         make(fire);
      } else if (scan.nextInt() == 3) {
         make(IA);
      } else if (scan.nextInt() == 4) {
         make(life);
      } else if (scan.nextInt() == 5) {
         make(MH);
      }
      scan.close();
      return true;
   }

   public boolean make(Insurance insurance) {
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("보장 내용 : ");
      insurance.setGuaranteedContent(scan.next());
      System.out.println("보험 대상 : ");
      insurance.setInsuranceTarget(scan.next());
      System.out.println("보험료 : ");
      insurance.setInsuranceFee(scan.nextInt());
      System.out.println("위반 시 위약금 : ");
      insurance.setPenalty(scan.nextInt());
      System.out.println("제한사항 (나이, 직업, 병력) : ");
      insurance.setRestriction(scan.next());
      System.out.println("보험이름 :");
      insurance.setInsuranceID(scan.next());
      insuranceList.add(insurance);
      
      scan.close();
      return true;
   }
   
   /////////////////////////////////////
   public String getGuaranteedContent() {
      return guaranteedContent;
   }

   public boolean setGuaranteedContent(String guaranteed_content) {
      guaranteedContent = guaranteed_content;
      return true;
   }

   public int getInsuranceFee() {
      return insuranceFee;
   }

   public boolean setInsuranceFee(int insurance_fee) {
      insuranceFee = insurance_fee;
      return true;
   }

   public String getInsuranceTarget() {
      return insuranceTarget;
   }

   public boolean setInsuranceTarget(String insurance_Target) {
      insuranceTarget = insurance_Target;
      return true;
   }

   public String getKindsOfInsurance() {
      return kindsOfInsurance;
   }

   public void setKindsOfInsurance(String kinds_of_Insurance) {
	   
      kindsOfInsurance = kinds_of_Insurance;
   }

   public int getPenalty() {
      return penalty;
   }

   public boolean setPenalty(int penalty) {
      this.penalty = penalty;
      return true;
   }

   public String getRestriction() {
      return restriction;
   }

   public boolean setRestriction(String restriction) {
      this.restriction = restriction;
      return true;
   }

   public Insurance getMInsurance() {
      return mInsurance;
   }

   public boolean setMInsurance(Insurance m_Insurance) {
      this.mInsurance = m_Insurance;
      return true;
   }

   public void association(InsuranceListImpl insuaranceList) {
      this.insuranceList = insuaranceList;
      
   }
}
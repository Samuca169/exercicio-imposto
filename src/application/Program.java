package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Renda anual com salário: ");
		double salarioAnual = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		double servicos = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		double capital = sc.nextDouble();
		System.out.print("Gastos médicos: ");
		double gastosMed = sc.nextDouble();
		System.out.print("Gastos educacionais:");
		double gastosEduc = sc.nextDouble();
		System.out.println();
		
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println();
		
		System.out.println("CONSOLIDADO DE RENDA:");
		double impSalario;
		if (salarioAnual / 12 < 3000.00) {
			impSalario = 0.0;
		}else {
			if (salarioAnual / 12 <= 5000.00) {
				impSalario = salarioAnual * 0.10;
			}else {
				impSalario = salarioAnual * 0.20;
			}
		}
		System.out.println("Imposto sobre salário: " + String.format("%.2f", impSalario));
		
		double impServicos = servicos * 0.15;
		System.out.println("Imposto sobre serviços: " + String.format("%.2f", impServicos));
		
		double impCapital = capital * 0.20;
		System.out.println("Imposto sobre ganho de capital: " + String.format("%.2f", impCapital));
		System.out.println();
		
		System.out.println("DEDUÇÕES:");
		double impBruto = impSalario + impServicos + impCapital;
		double maxDedutivel = impBruto * 0.30;
		System.out.println("Máximo dedutível: " + String.format("%.2f", maxDedutivel));
		
		double gastosDedutiveis = gastosMed + gastosEduc;
		System.out.println("Gastos dedutíveis: " + String.format("%.2f", gastosDedutiveis));
		System.out.println();
		
		double abatimento;
		if (gastosDedutiveis > maxDedutivel) {
			abatimento  = maxDedutivel;
		}else {
			abatimento = gastosDedutiveis;
		}
		
		double impDevido = impBruto - abatimento;
		
		System.out.println("RESUMO:");
		System.out.println("Imposto bruto total: " + String.format("%.2f", impBruto));
		System.out.println("Abatimento: " + String.format("%.2f", abatimento));
		System.out.println("Imposto devido: " + String.format("%.2f", impDevido));
		sc.close();
	}

}

package com.main;

import java.util.Random;

import com.sort.Sorter;

public class BucketSort {

	public static void main(String[] args) {
		int tamanhoDoVetor = 30;
		int max = 33333;

		int[] vetor = new int[tamanhoDoVetor];

		Random random = new Random();

		System.out.println("Elementos:");

		for (int i = 0; i < tamanhoDoVetor - 1; i++) {
			vetor[i] = random.nextInt(tamanhoDoVetor - i + 10);
			System.out.println("Elemento: " + vetor[i]
					+ " adicionado à posição " + i);
		}

		vetor[tamanhoDoVetor - 1] = max;

		long start = System.currentTimeMillis();
		Sorter.BucketSort(vetor, max);

		long elapsed = System.currentTimeMillis() - start;

		System.out.println("End " + elapsed + " ms");
	}

}

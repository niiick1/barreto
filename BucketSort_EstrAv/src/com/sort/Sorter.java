package com.sort;

import java.util.LinkedList;

public class Sorter {
	
	private final static int BUCKET_RANGE = 5;

	public static void BucketSort(int[] vetor, int maiorValor) {
		int numBaldes = maiorValor / BUCKET_RANGE;

		LinkedList<Integer>[] baldes = new LinkedList[numBaldes];

		// Inicializa o vetor
		for (int i = 0; i < numBaldes; i++) {
			baldes[i] = new LinkedList<Integer>();
		}

		int tamanhoDoArray = vetor.length;

		// Coloca os valores no balde respectivo:
		System.out.println("Colocando elementos nos baldes:");
		for (int ind = 0; ind < tamanhoDoArray; ind++) {
			int iteradorBalde = numBaldes - 1;
			while (true) {
				if (iteradorBalde < 0) {
					break;
				}
				if (vetor[ind] >= (iteradorBalde * BUCKET_RANGE)) {
					baldes[iteradorBalde].add(vetor[ind]);
					System.out.printf("Elemento vetor[%d]= %d adicionado ao balde número: %d\n", ind, vetor[ind], iteradorBalde);
					break;
				}
				iteradorBalde--;
			}
		}
		System.out.println("Fim da inserção dos elementos nos baldes");

		System.out.println("Listando os elementos do balde:");
		// Lista os baldes (Desnecessario para o algoritmo final)
		for (int indice = 0; indice < numBaldes; indice++) {
			if (baldes[indice].size() != 0) {
				System.out.println("Balde numero: " + indice);
				for (int iteradorBaldes = 0; iteradorBaldes < baldes[indice]
						.size(); iteradorBaldes++) {
					System.out.println("Elemento: "
							+ baldes[indice].get(iteradorBaldes));
				}
			}
		}

		System.out.println("Fim da listagem dos elementos dos baldes:");
		// Ordena e atualiza o vetor:
		int indice = 0;
		for (int ind = 0; ind < numBaldes; ind++) {

			int[] arrayAuxiliar = new int[baldes[ind].size()];

			// Coloca cada balde num vetor:
			for (int index = 0; index < arrayAuxiliar.length; index++) {
				arrayAuxiliar[index] = baldes[ind].get(index);
			}

			// Orderna o vetor com outro algoritimo
			insertionSort(arrayAuxiliar);

			// Devolve os valores ao vetor de entrada:
			for (int indiceAuxiliar = 0; indiceAuxiliar < arrayAuxiliar.length; indiceAuxiliar++, indice++) {
				vetor[indice] = arrayAuxiliar[indiceAuxiliar];
				System.out.print(vetor[indice] + " ");
			}
		}
		
		System.out.println();
	}

	public static void insertionSort(int elementos[]) {
		int eleito;
		for (int i = 1; i < elementos.length; i++) {
			eleito = elementos[i];
			int j;
			for (j = i - 1; (j >= 0) && (elementos[j] > eleito); j--) {
				elementos[j + 1] = elementos[j];
			}
			elementos[j + 1] = eleito;
		}
	}
}

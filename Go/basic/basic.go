// Este código é o exemplo básico de um programa paralelo utilizando goroutines e WaitGroup

package main

import "fmt"
import "sync"
import "time"

func loop1(wg * sync.WaitGroup) {
	for i := 1; i < 10; i++ {
		fmt.Println("loop1: ", i)
		time.Sleep(2 * time.Second)
	}

	wg.Done()
}

func loop2(wg * sync.WaitGroup) {
	for i := 1; i < 10; i++ {
		fmt.Println("loop2: ", i)
		time.Sleep(2 * time.Second)
	}

	wg.Done()
}

func main() {
	var wg sync.WaitGroup

	// bloco de execução paralela
	wg.Add(2)

	go loop1(&wg)
	go loop2(&wg)

	wg.Wait()
	// fim do bloco de execução paralela
}
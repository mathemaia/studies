package main

import "fmt"
import "sync"

var (
	mutex sync.Mutex
	wg sync.WaitGroup
	balance int
)

func deposit(value int, wg *sync.WaitGroup) {
	// fecha a sessão crítica
	mutex.Lock()

	// faz o deposito
	fmt.Printf("Deposito de %d\n", value)
	fmt.Printf("	Saldo anterior: %d\n", balance)
	balance += value
	fmt.Printf("	Saldo atual: %d\n", balance)
	
	// reabre a sessão crítica
	mutex.Unlock()

	// decrementa o waitgroup
	wg.Done()
}

func withdraw(value int, wg *sync.WaitGroup) {
	// fecha a sessão crítica
	mutex.Lock()

	// faz o saque
	fmt.Printf("Saque de %d\n", value)
	fmt.Printf("	Saldo anterior: %d\n", balance)
	balance -= value
	fmt.Printf("	Saldo atual: %d\n", balance)

	// reabre a sessão crítica
	mutex.Unlock()
	
	// decrementa o waitgroup
	wg.Done()
}

func main() {
	balance = 1000
	
	// abre o bloco de execução paralelo
	wg.Add(2)

	go deposit(700, &wg)
	go withdraw(300, &wg)

	// fecha o bloco de execução paralela
	wg.Wait()
}
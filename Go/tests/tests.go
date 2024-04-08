package main

import (
	"fmt"
	"sync"
	"time"
)

func loop1(wg *sync.WaitGroup) {
	for i := 0; i < 10; i++ {
		time.Sleep(3 * time.Second)
		fmt.Println("loop1: ", i)
	}

	wg.Done()
}

func loop2(wg *sync.WaitGroup) {
	for i := 0; i < 10; i++ {
		time.Sleep(3 * time.Second)
		fmt.Println("loop2: ", i)
	}

	wg.Done()
}

func main() {
	var wg sync.WaitGroup

	wg.Add(2)
	go loop1(&wg)
	go loop2(&wg)
	wg.Wait()
}
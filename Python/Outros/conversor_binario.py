# Conversor binário-decimal
# ex. entrada:
#   1001
#   b: 9

while True:
    binario = str(input('b:  '))
    binario = list(binario)
    decimal = 0

    for i, bit in enumerate(binario):
        i += 1
        bit = int(bit)
        decimal = decimal + (bit * pow(2, len(binario) - i))

    print(f'd:  {decimal}\n')

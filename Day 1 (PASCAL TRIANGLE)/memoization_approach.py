def generate_pascal_triangle(num_rows, memo={}):
    if num_rows == 0:
        return []
    elif num_rows == 1:
        return [[1]]
    elif num_rows in memo:
        return memo[num_rows]
    else:
        triangle = generate_pascal_triangle(num_rows - 1)
        prev_row = triangle[-1]
        current_row = [1]
        for i in range(len(prev_row) - 1):
            current_row.append(prev_row[i] + prev_row[i + 1])
        current_row.append(1)
        triangle.append(current_row)
        memo[num_rows] = triangle
        return triangle


# Test the function
num_rows = 5
triangle = generate_pascal_triangle(num_rows)

# Print the triangle
for row in triangle:
    print(row)

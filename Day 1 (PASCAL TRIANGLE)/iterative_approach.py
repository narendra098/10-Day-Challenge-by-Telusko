def generate_pascal_triangle(num_rows):
    triangle = []
    for row in range(num_rows):
        # Create a new row
        current_row = []
        
        # Calculate the values for the current row
        for col in range(row + 1):
            if col == 0 or col == row:
                # The first and last element of each row is always 1
                current_row.append(1)
            else:
                # Calculate the value based on the previous row
                prev_row = triangle[row - 1]
                current_value = prev_row[col - 1] + prev_row[col]
                current_row.append(current_value)
        
        # Add the current row to the triangle
        triangle.append(current_row)
    
    return triangle


# Test the function
num_rows = 5
triangle = generate_pascal_triangle(num_rows)

# Print the triangle
for row in triangle:
    print(row)

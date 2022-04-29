
# match regex to remove blank lines in google docs
def remove_blank_lines(file_name):
    import re
    with open(file_name, 'r') as f:
        lines = f.readlines()
    with open(file_name, 'w') as f:
        for line in lines:
            if re.match(r'^\s*$', line):
                continue
            f.write(line)

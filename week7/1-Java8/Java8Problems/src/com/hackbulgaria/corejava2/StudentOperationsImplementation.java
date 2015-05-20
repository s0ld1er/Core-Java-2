package com.hackbulgaria.corejava2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public class StudentOperationsImplementation implements StudentOperations {
    private List<Student> students;

    public StudentOperationsImplementation(List<Student> students) {
        this.students = students;
    }

    @Override
    public double getAverageMark() {
        return students.stream().mapToDouble(a -> a.getGrade()).average().getAsDouble();
    }

    @Override
    public List<Student> getAllPassing() {
        return students.stream().filter(a -> a.getGrade() >= 3.0).collect(Collectors.toList());

    }

    @Override
    public List<Student> getAllFailing() {
        return students.stream().filter(a -> a.getGrade() < 3.0).collect(Collectors.toList());
    }

    @Override
    public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
        return students.stream().collect(Collectors.partitioningBy(student -> student.getGrade() < splitMark ? Boolean.FALSE : Boolean.TRUE));
    }

    @Override
    public Map<Integer, List<Double>> getMarksDistributionByAge() {
        Set<Entry<Integer, List<Student>>> entrySet = students.stream().collect(Collectors.groupingBy(Student::getAge)).entrySet();
        return entrySet.stream().collect(
                Collectors.<Entry<Integer, List<Student>>, Integer, List<Double>> toMap(e -> e.getKey(),
                        e -> e.getValue().stream().map(g -> g.getGrade()).collect(Collectors.toList())));
    }

    @Override
    public List<Student> orderByMarkDescending() {
        return students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Student> orderByMarkAscending() {
        return students.stream().sorted(Comparator.comparing(Student::getGrade)).collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithLowestMarks() {
        return students.stream()
                .filter(student -> student.getGrade() == students.stream().min(Comparator.comparing(Student::getGrade)).get().getGrade())
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithHighestMarks() {
        return students.stream()
                .filter(student -> student.getGrade() == students.stream().max(Comparator.comparing(Student::getGrade)).get().getGrade())
                .collect(Collectors.toList());
    }

    @Override
    public Map<Gender, Double> getAverageMarkByGender() {
        Set<Entry<Gender, List<Student>>> entrySet = students.stream().collect(Collectors.groupingBy(Student::getGender)).entrySet();
        return entrySet.stream().collect(
                Collectors.<Entry<Gender, List<Student>>, Gender, Double> toMap(e -> e.getKey(),
                        e -> e.getValue().stream().mapToDouble(Student::getGrade).average().getAsDouble()));
    }

    @Override
    public Map<Double, Integer> getMarksDistribution() {
        Set<Entry<Double, List<Student>>> entrySet = students.stream().collect(Collectors.groupingBy(Student::getGrade)).entrySet();
        return entrySet.stream().collect(
                Collectors.<Entry<Double, List<Student>>, Double, Integer> toMap(e -> e.getKey(),
                        e -> (int) (long) e.getValue().stream().map(g -> g.getGrade()).collect(Collectors.counting())));
    }

    @Override
    public String getEmailToHeader() {
        return students.stream().map(Student::getEmail).collect(Collectors.joining(", "));
    }

    @Override
    public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
        Set<Entry<Gender, List<Student>>> entrySet = students.stream().collect(Collectors.groupingBy(Student::getGender)).entrySet();
        return entrySet.stream().collect(
                Collectors.<Entry<Gender, List<Student>>, Gender, Map<Integer, List<Student>>> toMap(e -> e.getKey(), e -> e.getValue().stream()
                        .collect(Collectors.groupingBy(Student::getAge))));
    }
}

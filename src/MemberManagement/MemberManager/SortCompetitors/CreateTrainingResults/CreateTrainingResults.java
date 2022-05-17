package MemberManagement.MemberManager.SortCompetitors.CreateTrainingResults;

import MemberManagement.MemberManager.CreateMembers.Member;

import java.util.List;

public interface CreateTrainingResults {
    List<TrainingResult> create(List<Member> members);
}

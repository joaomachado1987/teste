package academia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.academia.configs.PersistenceJPAConfig;
import br.com.academia.entity.Exercicio;
import br.com.academia.entity.GrupoMuscular;
import br.com.academia.entity.Objetivo;
import br.com.academia.entity.Treino;

public class Test {
	public static void main(String[] str) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Exercicio exercicio = new Exercicio();
		exercicio.setNomeExercicio("Rosca Direta");
		exercicio.setDescricao("Exercicio que trabalha no bíceps");
		exercicio.setGrupoMuscular(GrupoMuscular.BICEPS);
		exercicio.setObjetivo(Objetivo.GANHAR_MASSA);
		em.persist(exercicio);
		Treino treino = new Treino();
		treino.setNome("Treino A");
		treino.addExercicios(exercicio);		
		
		em.persist(treino);
//		em.getTransaction().commit();
		em.flush();
//		em.close();
//		emf.close();
	}
}

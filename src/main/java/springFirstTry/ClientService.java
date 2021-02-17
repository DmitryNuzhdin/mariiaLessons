package springFirstTry;

import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientServiceInterface {

    RequestEntityRepository myEntityRepository;

    public ClientService(RequestEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    @Override
    public void writeEntity(RequestEntity entity) {
        myEntityRepository.save(entity);
    }

    public long countEntity() {
        return myEntityRepository.count();
    }
}
